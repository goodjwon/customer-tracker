#!/usr/bin/python

import urllib
import urllib2

url = 'http://localhost:8080/customer/getCustomerList'

request = urllib2.Request(url, None, headers={'Connection': 'keep-alive','Content-Type': 'text/plain;charset=UTF-8','Cache-Control':'private, max-age=0'})

response = urllib2.urlopen(request)
the_page = response.read()

print the_page
