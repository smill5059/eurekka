from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import urllib.request
import pandas as pd
import csv

f = open('바코드연계제품이미지.csv', 'w', encoding='utf-8-sig', newline='')
wr = csv.writer(f)
# data_type = ['PRDLST_NM','IMG_URL']
# wr.writerow(data_type)

xlsx = pd.read_excel('./바코드연계제품.xlsx',engine='openpyxl')
product_names = xlsx['PRDLST_NM']

driver = webdriver.Chrome()

for name in product_names:

    driver.get("https://www.google.co.kr/imghp?hl=ko&tab=wi&authuser=0&ogbl")
    elem = driver.find_element_by_name("q")
    elem.send_keys(name)
    elem.send_keys(Keys.RETURN)
    try:
        image = driver.find_elements_by_css_selector(".rg_i.Q4LuWd")[0]
    except:
        product_image = [name,"NONE"]
        wr.writerow(product_image)

    try:
        image.click()
        time.sleep(2)
        imgUrl = driver.find_element_by_xpath('/html/body/div[2]/c-wiz/div[3]/div[2]/div[3]/div/div/div[3]/div[2]/c-wiz/div/div[1]/div[1]/div/div[2]/a/img').get_attribute("src")
        product_image = [name,imgUrl]
        wr.writerow(product_image)
    except:
        pass

   
driver.close()
f.close()
