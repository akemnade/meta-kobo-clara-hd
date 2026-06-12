
DESCRIPTION = "This is the basic core image for Kobo Clara HD"

inherit core-image

IMAGE_FEATURES += " \
    splash \
    ssh-server-openssh \
    hwcodecs \
    x11-base \
"
SDKIMAGE_FEATURES:append = " \
    staticdev-pkgs \
"

IMAGE_INSTALL:append = " \
    u-boot-kobo-fw-utils \
    sudo \
    networkmanager \
    tzdata \
    screen \
    xev \
    rauc \
"

IMAGE_INSTALL:remove += " virtual/perf"

inherit extrausers
EXTRA_USERS_PARAMS = "usermod -L root"
