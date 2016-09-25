#!/usr/bin/env python

import sys
# Please do not use any URL, URI, or regular expression modules or libraries.

class ParsedUrl(object):
  def __init__(self, protocol, host, pathname, query_hash):
    self.protocol = protocol
    self.host = host
    self.pathname = pathname
    self.query_hash = query_hash

  def __str__(self):
    return ', '.join([ "{k}: '{v}'".format(k=k, v=self.__dict__[k]) for k in self.__dict__ ])

  def __repr__(self):
    return self.__str__()

  @staticmethod
  def parse_from_string(input):
    splitInput = input.split('/')
    orderAndPath = '/'.join(splitInput[3:]).split('?')
    pathname = orderAndPath[0] if orderAndPath[0] else '/'
    query_hash = {}
    for kwarg in orderAndPath[1].split('&'):
      kvPair = kwarg.split('=')
      query_hash[kvPair[0]] = kvPair[1]
    return ParsedUrl(splitInput[0:-1], splitInput[2], pathname, query_hash)

def main(argv):
  # Should print something like:
  # protocol: 'http', host: 'test.com:8888', pathname: 'order/search', queryHash: {keyword: awesome}
  print ParsedUrl.parse_from_string("http://test.com:8888/order/search?keyword=awesome")

if __name__ == '__main__':
  sys.exit(main(sys.argv[1:]))
