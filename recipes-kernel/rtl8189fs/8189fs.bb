SUMMARY = "RTL8189FS wifi module"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://Makefile;beginline=1;endline=1;md5=8e0ee9938408d68917fc9a8dd7a44ce7"

inherit module

SRC_URI = "git://github.com/jwrdegoede/rtl8189ES_linux.git;protocol=https;branch=rtl8189fs \
           file://0001-Fix-build-problems-in-Yocto.patch \
           "
SRCREV = "5d523593f41c0b8d723c6aa86b217ee1d0965786"

S = "${WORKDIR}/git"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.

RPROVIDES_${PN} += "kernel-module-8189fs"

# This module's makefile doesn't follow the usual conventions.
MODULES_INSTALL_TARGET = "install"

do_install_prepend() {
    install -d ${D}${nonarch_base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/net/wireless
}
