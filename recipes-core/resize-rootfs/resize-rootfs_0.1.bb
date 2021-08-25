SUMMARY = "rootfs resize"
SECTION = "Custom Apps"
DESCRIPTION = "Recipe created by bitbake-layers"
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"




SRC_URI +="file://resize-helper"
SRC_URI +="file://resize-helper.service"

S = "${WORKDIR}"

inherit systemd allarch

do_install () {

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${S}/resize-helper.service ${D}${systemd_unitdir}/system/

    install -d ${D}${sbindir}
    install -m 0755 ${S}/resize-helper ${D}${sbindir}/
}


SYSTEMD_SERVICE_${PN} = "resize-helper.service"
RDEPENDS_${PN} += "e2fsprogs-resize2fs gptfdisk parted util-linux"


FILES_${PN} += "${sbindir}/resize-helper"
