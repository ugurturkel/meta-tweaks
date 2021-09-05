#!/bin/sh
rfkill unblock all
wpa_supplicant -Dnl80211 -iwlan0 -c/etc/wpa_supplicant.conf
ifconfig wlan0 192.168.1.166
route add default gw 192.168.1.1
: exit 0
