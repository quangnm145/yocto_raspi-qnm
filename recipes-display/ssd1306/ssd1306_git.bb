# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b694e603a996c3bfdc6093ed1f70c8f"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/armlabs/ssd1306_linux.git;protocol=https;branch=master"
SRC_URI += "file://0001-ssd1306-qmn-custom.patch"

# Modify these as desired
PV = "1.0+git"
SRCREV = "7ea348e41accda62c9d5febb74812ac90e5e44cf"

S = "${WORKDIR}/git"

# coreutils provides fmt which is used in the Makefile
DEPENDS = "i2c-tools coreutils-native"

EXTRA_OEMAKE = "CC='${CC}' CFLAGS='${CFLAGS}' LDFLAGS='${LDFLAGS}'"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/ssd1306_bin ${D}${bindir}/ssd1306
}

