SUMMARY = "Simple Hello World recipe"
DESCRIPTION = "Recipe created by QuangNM"
LICENSE = "MIT"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello.txt \
           file://hello.sh"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/hello.txt ${D}${sysconfdir}/hello.txt
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/hello.sh ${D}${bindir}/hello.sh
}