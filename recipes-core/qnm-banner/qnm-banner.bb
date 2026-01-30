TMPDIR = "${TOPDIR}/tmp"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI = "file://qnm-banner.sh file://COPYING.MIT"

DESCRIPTION = "QNM login banner with system info"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}/profile.d
    install -m 0755 ${WORKDIR}/qnm-banner.sh ${D}${sysconfdir}/profile.d/
}
