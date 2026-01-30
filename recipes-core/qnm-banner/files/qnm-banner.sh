#!/bin/sh
echo "
   ____  _   _ __  __ 
  / __ \| \ | |  \/  |
 | |  | |  \| | \  / |
 | |  | | . ` | |\/| |
 | |__| | |\  | |  | |
  \___\_\_| \_|_|  |_|
                      
  Uptime     : $(uptime)
  Hostname   : $(hostname)
  Disk Usage : $(df -h | awk '/\/$/ {print $3 " used of " $2}')
  Memory     : $(free | awk '/Mem:/ {printf "%.1fM used of %.1fM", $3/1024, $2/1024}')
" 
