import csv
import json
import urllib.request, urllib.parse, urllib.error


f = open('바코드연계제품.csv', 'w', encoding='utf-8-sig', newline='')
wr = csv.writer(f)
data_type = ['PRDLST_REPORT_NO','PRMS_DT','END_DT','PRDLST_NM','POG_DAYCNT','PRDLST_DCNM','BSSH_NM','INDUTY_NM','SITE_ADDR','CLSBIZ_DT','BAR_CD']
wr.writerow(data_type)


#########################################################
start = 1
end = 1000

while end < 100001 :    
    url = "http://openapi.foodsafetykorea.go.kr/api/d9c714fad5b143629fac/C005/json/" + str(start) + "/" + str(end)
    uh = urllib.request.urlopen(url)
    barcode_data = uh.read().decode()
    json_data = (json.loads(barcode_data))['C005']['row']
    
    for i in range(0, 1000):
        product = [json_data[i]['PRDLST_REPORT_NO'],json_data[i]['PRMS_DT'],json_data[i]['END_DT'],json_data[i]['PRDLST_NM'],json_data[i]['POG_DAYCNT'],json_data[i]['PRDLST_DCNM'],json_data[i]['BSSH_NM'],json_data[i]['INDUTY_NM'],json_data[i]['SITE_ADDR'],json_data[i]['CLSBIZ_DT'],json_data[i]['BAR_CD']]
        wr.writerow(product)
    
    start += 1000
    end += 1000

url = "http://openapi.foodsafetykorea.go.kr/api/d9c714fad5b143629fac/C005/json/100001/100526"
uh = urllib.request.urlopen(url)
barcode_data = uh.read().decode()
json_data = (json.loads(barcode_data))['C005']['row']

for i in range(0, 526):
    product = [json_data[i]['PRDLST_REPORT_NO'],json_data[i]['PRMS_DT'],json_data[i]['END_DT'],json_data[i]['PRDLST_NM'],json_data[i]['POG_DAYCNT'],json_data[i]['PRDLST_DCNM'],json_data[i]['BSSH_NM'],json_data[i]['INDUTY_NM'],json_data[i]['SITE_ADDR'],json_data[i]['CLSBIZ_DT'],json_data[i]['BAR_CD']]
    wr.writerow(product)


f.close()