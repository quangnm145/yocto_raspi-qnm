SUMMARY = "Simple Hello World recipe"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hello.txt \
           file://hello.sh"

# Quan trọng: Định nghĩa thư mục làm việc cho các file local
S = "${WORKDIR}"

do_install() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${S}/hello.txt ${D}${sysconfdir}/hello.txt
    
    install -d ${D}${bindir}
    install -m 0755 ${S}/hello.sh ${D}${bindir}/hello.sh
}

# Đóng gói các file vào package chính
FILES:${PN} += "${sysconfdir}/hello.txt ${bindir}/hello.sh"
