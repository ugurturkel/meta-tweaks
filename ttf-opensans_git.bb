############################################################################
##
## Copyright (C) 2021 The Qt Company Ltd.
## Contact: https://www.qt.io/licensing/
##
## This file is part of the Boot to Qt meta layer.
##
## $QT_BEGIN_LICENSE:GPL$
## Commercial License Usage
## Licensees holding valid commercial Qt licenses may use this file in
## accordance with the commercial license agreement provided with the
## Software or, alternatively, in accordance with the terms contained in
## a written agreement between you and The Qt Company. For licensing terms
## and conditions see https://www.qt.io/terms-conditions. For further
## information use the contact form at https://www.qt.io/contact-us.
##
## GNU General Public License Usage
## Alternatively, this file may be used under the terms of the GNU
## General Public License version 3 or (at your option) any later version
## approved by the KDE Free Qt Foundation. The licenses are as published by
## the Free Software Foundation and appearing in the file LICENSE.GPL3
## included in the packaging of this file. Please review the following
## information to ensure the GNU General Public License requirements will
## be met: https://www.gnu.org/licenses/gpl-3.0.html.
##
## $QT_END_LICENSE$
##
############################################################################

SUMMARY = "Open Sans Fonts"
SECTION = "fonts"
HOMEPAGE = "https://fonts.google.com"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://apache/opensans/LICENSE.txt;md5=d273d63619c9aeaf15cdaf76422c4f87"

INHIBIT_DEFAULT_DEPS = "1"

inherit allarch fontcache

SRC_URI = "git://github.com/google/fonts;branch=main"
SRCREV = "beaec0837bd21524b57ecb435158f9011fc03999"

S = "${WORKDIR}/git"

do_install() {
    install -m 0755 -d ${D}${datadir}/fonts/truetype/opensans
    install -m 0644 apache/opensans/*.ttf ${D}${datadir}/fonts/truetype/opensans
}

PACKAGES = "${PN}"
FILES_${PN} += "${datadir}/fonts/truetype/opensans"
