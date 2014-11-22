'''
Created on Nov 21, 2014

@author: xiaocunqi
'''

from datetime import datetime
from Processor import URLProcessor
from multiprocessing.pool import Pool

rootURL = "http://www.allmacwallpaper.com"

firstView = "/retina-macbook-pro-wallpapers/Views/1"

startPage = rootURL + firstView

#log operation message
def log(message):
    print("[" + message + "] - " + str(datetime.now()) + "\n");
        
def getDataPages():
    urlProcessor = URLProcessor()
    html = urlProcessor.getHtmlWithURL(startPage)
    
    links = urlProcessor.getPageLinks(html)
    links.insert(0, firstView)
    
    for e in links:
        html = urlProcessor.getHtmlWithURL(rootURL + e)
        result = urlProcessor.getPicLinks(html)
        
        for p in result:
            print(p[1])

def downloadPic(urlAndName):
    urlProcessor = URLProcessor()
    reaLink = urlProcessor.getRealDownloadLink(urlAndName[0], rootURL)
    
    if reaLink != None:
        urlProcessor.downloadPicture(reaLink, urlAndName[1])

def execute():
    urlProcessor = URLProcessor()
    
    links = urlProcessor.generatePageViews(rootURL, 11)
    
    result = urlProcessor.getPicLinks(links, rootURL)
    
    pool = Pool(8)
    log("Downloading...")
    pool.map(downloadPic, result)
    log("Done!")

if __name__ == '__main__':
    execute()