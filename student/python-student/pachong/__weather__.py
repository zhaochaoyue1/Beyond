from bs4 import BeautifulSoup
import requests
import json
url = "https://search.cctv.com/ifsearch.php?page=1&qtext=%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5&sort=date&pageSize=20&type=video&vtime=-1&datepid=3&channel=CCTV%E5%85%B6%E4%BB%96&pageflag=0&qtext_str=%E5%A4%A9%E6%B0%94%E9%A2%84%E6%8A%A5"
response = requests.get(url)
response.encoding = "utf-8"
text = response.text
loads = json.loads(text)
get = loads.get('list')[0].get("urllink")
split = str.split(get, '/')
print(get)
print(split)


