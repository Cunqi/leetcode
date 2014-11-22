'''
Created on Nov 20, 2014

@author: xiaocunqi
'''

from HtmlProcessor import URLProcessor
from _datetime import datetime
pictureDir = "/Users/xiaocunqi/pictures/background/"
def controLog(message):
    print("[" + message + "] - " + str(datetime.now()) + "\n");

def getFilePath(fileName):
    return pictureDir + fileName + ".jpg"

def execute():
    firstPageURL = "http://www.allmacwallpaper.com/retina-macbook-pro-wallpapers/Views"
    prefix = 'http://www.allmacwallpaper.com'
    
    controLog("Start BackgroundGraber...")
    
    controLog("Initializing URLProcessor...")
    
    urlProcessor = URLProcessor()
   
    controLog("Done!")
    
    controLog("Parsing first page URL...")
    html = urlProcessor.findPageByURL(firstPageURL)
    urlProcessor.fetchViewPages(html, prefix, 10)
    
    lists = urlProcessor.getPages()
    lists.insert(0, firstPageURL)
    
    controLog("Done!")
    
    controLog("Finding Picture Real Links...")
    controLog("Loading...")
    for e in lists:
        urlProcessor.fetchDownloadableLinksByURL(e, prefix)
    controLog("Done!")
    
    controLog("Listing downloadable pages' URL...")
    
    controLog("Downloading Picture...")
    controLog("Loading...")
    downloadable = urlProcessor.getDownloadable()
    for e in downloadable:
        urlProcessor.downloadPicture(e, getFilePath(str(datetime.now().microsecond)))
        
    controLog("Done!")
        
if __name__ == '__main__':
    execute()