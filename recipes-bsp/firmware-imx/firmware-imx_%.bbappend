SRC_URI += "file://epdc_PENG060D.fw;subdir=firmware-imx-${PV}-${IMX_SRCREV_ABBREV}/firmware/epdc/"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

