FROM mcr.microsoft.com/devcontainers/base:ubuntu

RUN apt-get update && apt-get install -y build-essential chrpath cpio debianutils diffstat file gawk gcc git iputils-ping libacl1 locales \
        python3 python3-git python3-jinja2 python3-pexpect python3-pip python3-subunit python3-matplotlib python3-numpy socat texinfo unzip wget xz-utils zstd lz4 tmux

RUN echo "en_US.UTF-8 UTF-8" >> /etc/locale.gen && locale-gen && update-alternatives --install /usr/bin/python editor /usr/bin/python3 100
