import time
from datetime import datetime as dt

path_temp ="C:\Study\App3\hosts"
path = "C:\Windows\System32\drivers\etc\hosts"
website_list = ["facebook.com", "www.facebook.com", "www.reddit.com", "reddit.com", "instagram.com", "imgur.com"]
redirect = "127.0.0.1"

while True:
    if dt(dt.now().year,dt.now().month,dt.now().day,8) < dt.now() < dt(dt.now().year,dt.now().month,dt.now().day,12):
        print("Working Hours..")
        with open(path,'r+') as file:
            content = file.read()
            for website in website_list:
                if website in content:
                    pass
                else:
                    file.write("\n"+ redirect + "     " + website)
    else:
        with open(path,'r+') as file:
            content=file.readlines()
            file.seek(0)
            for line in content:
                if not any(website in line for website in website_list):
                    file.write(line)
            file.truncate()
        print("Fun Hours..")
    time.sleep(30)

host_file= file.open("hosts", 'r')
