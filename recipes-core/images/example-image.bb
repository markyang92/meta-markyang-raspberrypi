include recipes-core/images/rpi-basic-image.bb

COMPATIBLE_MACHINE = "^rpi$"

IMAGE_INSTALL += "i2c-tools vim"





IMAGE_INSTALL += "tzdata tzdata-misc"

# Set default timezone
DEFAULT_TIMEZONE = "Japan"


IMAGE_INSTALL += "networkmanager networkmanager-nmtui networkmanager-bash-completion"

IMAGE_INSTALL += "cinematicexperience"

# ==== core-image-weston ===== #
IMAGE_FEATURES += "splash package-management ssh-server-dropbear hwcodecs"

inherit features_check

REQUIRED_DISTRO_FEATURES = "wayland"

#IMAGE_INSTALL += "weston weston-init weston-examples gtk+3-demo clutter-1.0-examples"
IMAGE_INSTALL += "weston weston-examples gtk+3-demo clutter-1.0-examples"
IMAGE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal', '', d)}"