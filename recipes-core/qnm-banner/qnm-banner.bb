TMPDIR = "${TOPDIR}/tmp"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI = "file://qnm-banner.sh file://COPYING.MIT"

DESCRIPTION = "QNM login banner with system info"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=04026fa0bcdc69bf6b9e72d6c96e25ae"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 ${WORKDIR}/qnm-banner.sh ${D}${sysconfdir}/profile.d/
}
