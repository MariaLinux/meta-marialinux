#
# Setup a non-root user for everyday work that has sudo abilities
#

DEVELOPER_USERNAME = "marie"
# Generate password with `mkpasswd <my-password>`.
# "marie" = "marie"
DEVELOPER_PASSWORD = "marie"
DEVELOPER_UID = "1200"
DEVELOPER_GID = "1200"

# 'extrausers' reads EXTRA_USERS_PARAMS.
# https://git.yoctoproject.org/cgit.cgi/poky/plain/meta/classes/extrausers.bbclass
inherit extrausers
EXTRA_USERS_PARAMS = "\
    useradd --password ${DEVELOPER_PASSWORD} --shell /bin/bash --uid ${DEVELOPER_UID} --user-group ${DEVELOPER_USERNAME}; \
    usermod --append --groups video,dialout,tty,audio,input,lp ${DEVELOPER_USERNAME}; \
"
setup_nonroot_user() {
    chown --recursive ${DEVELOPER_USERNAME}:${DEVELOPER_USERNAME} ${IMAGE_ROOTFS}/home/${DEVELOPER_USERNAME}
    echo "${DEVELOPER_USERNAME} ALL=(ALL) NOPASSWD: ALL" >> ${IMAGE_ROOTFS}/etc/sudoers
}
ROOTFS_POSTPROCESS_COMMAND:append = " setup_nonroot_user;"
