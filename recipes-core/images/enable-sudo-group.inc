enable_sudoers_group() {
    echo "%sudo ALL=(ALL) NOPASSWD: ALL" >> ${IMAGE_ROOTFS}/etc/sudoers
}
ROOTFS_POSTPROCESS_COMMAND:append = " enable_sudoers_group;"
