#!/bin/sh
cat << 'EOF'
   ____  _   _ __  __ 
  / __ \| \ | |  \/  |
 | |  | |  \| | \  / |
 | |  | | . ` | |\/| |
 | |__| | |\  | |  | |
  \___\_\_| \_|_|  |_|
EOF

echo "  Uptime     : $(uptime)"
echo "  Hostname   : $(hostname)"
echo "  Disk Usage : $(df -h | awk '/\/$/ {print $3 " used of " $2}')"
echo "  Memory     : $(free | awk '/Mem:/ {printf "%.1fM used of %.1fM", $3/1024, $2/1024}')"
