SUMMARY = "bitbake-layers recipe"
SECTION = "Custom Apps"
DESCRIPTION = "Recipe created by bitbake-layers"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI +="file://autostart-wifi.sh"
SRC_URI +="file://autostart-wifi.service"

S = "${WORKDIR}"


inherit systemd

do_install() {

    
    install -d ${D}/opt/rfid-prototype/bin
    install -m 0755 ${S}/autostart-wifi.sh ${D}/opt/rfid-prototype/bin/
    
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/autostart-wifi.service ${D}${systemd_unitdir}/system/
    
}

FILES_${PN} += "${systemd_unitdir}/system/autostart-wifi.service"
FILES_${PN} += "/opt/rfid-prototype"

SYSTEMD_SERVICE_${PN} += "autostart-wifi.service"

