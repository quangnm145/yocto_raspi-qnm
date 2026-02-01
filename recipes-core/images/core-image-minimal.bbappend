# User "root" has password set to "test" in the image.
# printf "%q" $(mkpasswd -m sha256crypt test)
# \$5\$1ywTDE4jLgPDskTp\$yK5Ap.2xjc5gYeFQ4MGvR6C0VzA4VDSMIFkQ5.TJO84
inherit extrausers
PASSWD = "\$5\$y9Aeg5ctwntRHo/g\$CAKtoTfQg7VPGfVAMGo5ZG/0GJLn3AD0JdoQ.i0dDFC"
EXTRA_USERS_PARAMS = "\
    usermod -p '${PASSWD}' root; \
    "

#Set rootfs to 200MiB by default
IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_SIZE ?= "204800"
IMAGE_ROOTFS_MAXSIZE = "2097152"

IMAGE_INSTALL:append = " qnm-banner"

IMAGE_INSTALL:append = " \
    dhcpcd \
    iproute2 \
    iputils \
    openssh \
    bash \
    tar \
    xz \
    procps \
    coreutils \
    curl \
    libgcc \
    libstdc++ \
    libatomic \
"
