'''
Created on Nov 21, 2014

@author: xiaocunqi
'''
from urllib import request
from bs4 import BeautifulSoup
class URLProcessor:
    pictureDir = "/Users/xiaocunqi/pictures/background/"
    #get Html of specific URL
    def getHtmlWithURL(self, url):
        if url != None:
            response = request.urlopen(url)
            return response.read()
        
        return None
    
    #generate pages to view
    def generatePageViews(self, rootURL, limits):
        links = []
        midPath = "/retina-macbook-pro-wallpapers/Views/"
        for i in range(1, limits):
            links.append(rootURL + midPath + str(i))
        return links
    
    #get Pic real link
    def __getPicLinks__(self, page, rootURL):
        parser = BeautifulSoup(page)
        links = parser.select("h3.title a[href*=/mac-wallpaper/]")
        result = []
        
        tmp = [0] * 2
        for link in links:
            tmp[0] = rootURL + link.attrs.get('href') #URL
            tmp[1] = link.text.strip()
            tmp[1] = tmp[1].replace(' ', '-')   #fileName
            result.append(tmp[:])
            
        return result
    
    def getPageLinks(self, page):
        parser = BeautifulSoup(page)
        links = parser.select("a[href*=retina-macbook-pro-wallpapers/Views/]")
        del links[len(links) - 1]
        result = [a.attrs.get('href') for a in links]
        
        return result
    
    def getRealDownloadLink(self, url, rootURL):
        html = self.getHtmlWithURL(url)
        parser = BeautifulSoup(html)
        
        link = parser.select("a[href^=/get/Retina-MacBook-Pro-13-inch-wallpapers/]")
        
        if len(link) == 1:
            return rootURL + link[0]['href']
        
        return None
    
    def getPicLinks(self, links, rootURL):
        result = []
        for link in links:
            html = self.getHtmlWithURL(link)
            tmp = self.__getPicLinks__(html, rootURL)
            result.extend(tmp[:])
        
        return result
    
    def downloadPicture(self, url, fileName):
        request.urlretrieve(url, self.pictureDir + fileName + ".jpg")