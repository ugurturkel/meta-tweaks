#!/bin/sh
rfkill unblock all
ifconfig wlan0 192.168.1.166
route add default gw 192.168.1.1
wpa_supplicant -Dnl80211 -iwlan0 -c/etc/wpa_supplicant.conf
: exit 0
