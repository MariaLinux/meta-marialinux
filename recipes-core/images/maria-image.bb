DESCRIPTION = "A development image with tools for daily work"
LICENSE = "MIT"

NICE_TO_HAVE = " \
    bash \
    bash-completion \
    gnupg \
    man \
    rsync \
    sudo \
    tmux \
    tree \
    vim-tiny \
    xterm \
    xz \
    zip \
"

SYSTEM = "\
    devmem2 \
    evtest \
    fbset \
    file \
    htop \
    lsb-release \
    lsof \
    nfs-utils-client \
    openssh-sftp-server \
    os-release \
    pciutils \
    psmisc \
    systemd-analyze \
    usbutils \
    util-linux \
"

DISKTOOLS = " \
    dosfstools \
    e2fsprogs-badblocks \
    e2fsprogs-dumpe2fs \
    e2fsprogs-e2fsck \
    e2fsprogs-e2scrub \
    e2fsprogs-mke2fs \
    e2fsprogs-resize2fs \
    e2fsprogs-tune2fs \
    hdparm \
    mmc-utils \
    smartmontools \
"

NETWORKING = " \
    ethtool \
    iftop \
    iperf3 \
    iproute2 \
    obexftp \
    rfkill \
    ser2net \
"

GSTREAMER = " \
    gstreamer1.0 \
    gstreamer1.0-doc \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-bad \
"

DEV_STACK = " \
        libgpiod \
        libgpiod-tools \
"

SECURITY = " \
    polkit \
"

# poky/meta/recipes-core/images/core-image-minimal.bb
# sets IMAGE_INSTALL according to CORE_IMAGE_EXTRA_INSTALL.
CORE_IMAGE_EXTRA_INSTALL = " \
    ${NICE_TO_HAVE} \
    ${SYSTEM} \
    ${DISKTOOLS} \
    ${NETWORKING} \
    ${GSTREAMER} \
    ${DEV_STACK} \
    ${SECURITY} \
    ptest-runner \
"

IMAGE_FEATURES = "\
    ssh-server-openssh \
    empty-root-password \
    allow-root-login \
    bash-completion-pkgs \
    debug-tweaks \
"

require recipes-core/images/core-image-minimal.bb

require add-user.inc
require enable-sudo-group.inc
