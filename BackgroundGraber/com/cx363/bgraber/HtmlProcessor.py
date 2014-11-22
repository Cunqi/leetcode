'''
Created on Nov 20, 2014

@author: xiaocunqi
'''
from urllib import request
from bs4 import BeautifulSoup
#to process the request and response from Web
class URLProcessor:
    _pageDict_ = []
    _downloadablePages_ = []
    
    #get a page from url
    def findPageByURL(self, url):
        if url == None:
            raise NoneError("Missing URL.")
        response = request.urlopen(url)
        html = response.read()
        
        return html
    
    def fetchDownloadableLinksByURL(self, url, prefix):
        html = self.findPageByURL(url)
        self.fetchDownloadableLinks(html, prefix)
    
    def fetchDownloadableLinks(self, html, prefix):
        soup = BeautifulSoup(html)
        linkLists = soup.find_all('a')
        tmp = []
        for link in linkLists:
            if link.find('img') != None:
                tmp.append(prefix + link['href'])
                
        del tmp[0]
        
        result = self.getDownloadableAddress(tmp, prefix)
        
        self._downloadablePages_.extend(result[:])
                        
    def fetchViewPages(self, start, prefix, limits):
        soup = BeautifulSoup(start)
        linkLists = soup.find_all('a')
        for link in linkLists:
            if link.text != None and link.text.isdigit():
                if int(link.text) <= limits:
                    self._pageDict_.append(prefix + link['href'])
                    
    def getDownloadableAddress(self, urls, prefix):
        result = []
        for url in urls:
            html = self.findPageByURL(url)
            bSoup = BeautifulSoup(html)
            tmp = bSoup.find_all('a', {}, True, 'Retina MacBook Pro 13-inch (2560x1600)', None)
            
            if len(tmp) == 1:
                result.append(prefix + tmp[0]['href'])
        
        return result
    
    def downloadPicture(self, url, filePath):
        request.urlretrieve(url, filePath)
                                               
    def getDownloadable(self):
        return self._downloadablePages_
    def getPages(self):
        return  self._pageDict_
    
class NoneError(Exception):
    def __init__(self, value):
        self.value = value
    def __str__(self):
        return repr(self.value)