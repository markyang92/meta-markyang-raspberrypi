PACKAGECONFIG:append = " wayland-brcm wayland-client wayland-server wayland-egl wayland-drm-egl-server-buffer"


FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += " \
file://qt-qpa.sh \
"

do_install_append() {
    install -d "${D}${sysconfdir}/profile.d"
    install -m 0644 "${WORKDIR}/qt-qpa.sh" "${D}${sysconfdir}/profile.d"
}