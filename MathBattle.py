#!/bin/usr/python
#+================================================+
#|            MathBattle Telegram Bot             |
#+------------------------------------------------+
#| Created by iamnubs on Saturday, 8 Oktober 2016 |
#+================================================+

from __future__ import unicode_literals
import BeautifulSoup
from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("https://tbot.xyz/math/")

point = 0

time.sleep(1)
print'Ready'
time.sleep(1)
print'Go...'
driver.execute_script("return document.getElementsByClassName('icon_play')[0].click()")

while True:
    def cek(params):
        return {
            '43': x + y == r,
            '120': x * y == r,
            '215': x * y == r,
            '47': x / y == r,
            '8211': x - y == r,

        }[params]


    html = driver.execute_script("return document.getElementsByTagName('html')[0].innerHTML")

    soup = BeautifulSoup.BeautifulSoup(html)
    x = int(soup.findAll("span", {"id": "task_x"})[0].string)
    y = int(soup.findAll("span", {"id": "task_y"})[0].string)
    r = int(soup.findAll("span", {"id": "task_res"})[0].string)
    sign = soup.findAll("span", {"id": "task_op"})[0].string
    op = ord(sign)
    if cek(str(op)):
        print "{:<3} {:<1} {:<3} {:<1} {:<4}{:<}".format(str(x), sign, str(y), '=', str(r), ' [ Benar ]')
        driver.execute_script("return document.getElementsByClassName('button')[0].click()")
    else:
        driver.execute_script("return document.getElementsByClassName('button')[1].click()")
        print "{:<3} {:<1} {:<3} {:<1} {:<4}{:<}".format(str(x), sign, str(y), '=', str(r), ' [ Salah ]')

    # time.sleep(0.5) #optional
