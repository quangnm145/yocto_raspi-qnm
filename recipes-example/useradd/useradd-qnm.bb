SUMMARY = "Tạo user thường qnmuser"
LICENSE = "CLOSED"

inherit useradd

USERADD_PACKAGES = "${PN}"

# SỬA ĐỔI: Tách tham số và dùng dấu nháy đơn cực kỳ cẩn thận với mật khẩu hash
# Lưu ý: Không nên dùng -p trực tiếp nếu hash có quá nhiều ký tự đặc biệt khó kiểm soát
# Dưới đây là cách thoát chuỗi hash chuẩn hơn cho BitBake
PASSWD_USER = "\$5\$y9Aeg5ctwntRHo/g\$CAKtoTfQg7VPGfVAMGo5ZG/0GJLn3AD0JdoQ.i0dDFC"
USERADD_PARAM:${PN} = "-u 1000 -m -d /home/qnmuser -s /bin/sh -p '${PASSWD_USER}' qnmuser"

do_install() {
    # Tạo thư mục với quyền mặc định
    install -d -m 0755 ${D}/home/qnmuser
}

# SỬA ĐỔI: Sử dụng pkg_postinst để đảm bảo user đã tồn tại trước khi chown
pkg_postinst:${PN} () {
    chown -R qnmuser:qnmuser $D/home/qnmuser
}

FILES:${PN} = "/home/qnmuser"
