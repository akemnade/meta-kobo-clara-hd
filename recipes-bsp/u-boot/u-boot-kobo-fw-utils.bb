require u-boot-fw-utils_2019.07.bb

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

UBOOT_SRC ?= "git://github.com/akemnade/u-boot-fslc.git;protocol=https"
SRCBRANCH = "kobo-2023-10"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH} \
           file://fw_env.config \
           "
SRCREV = "1f55e1ef7b1ac1e0cdb1375e787f287c33599220"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-kobo"

PROVIDES += "u-boot-fw-utils"
RPROVIDES:${PN} += "u-boot-fw-utils"

# The envtools target is just called env in older U-boot
do_compile () {
	oe_runmake ${UBOOT_MACHINE}
	oe_runmake envtools
}

# Install our fw_env.config rather than the default.
do_install:append () {
    install -m 0644 ${WORKDIR}/sources/fw_env.config ${D}${sysconfdir}/fw_env.config
}
