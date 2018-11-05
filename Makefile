.DEFAULT_GOAL := default

QUINN_FFI_H := quinn-ffi/target/quinn_ffi.h
QUINN_FFI_TOML := quinn-ffi/Cargo.toml

# Checkout the FFI library
$(QUINN_FFI_TOML):
	cd quinn-ffi && git submodule init && git submodule update

# If the header is not available, build the path
# TODO: this can be imroved to depend on all Rust source, and then it would rebuild...
$(QUINN_FFI_H): $(QUINN_FFI_TOML)
	cd quinn-ffi && cargo build --release

.PHONY: default
default: $(QUINN_FFI_H)

.PHONY: clean
clean:
	test -f quinn-ffi/Cargo.toml && cd quinn-ffi && cargo clean
	git submodule deinit --all

.PHONY: update
update: $(QUINN_FFI_TOML)
	git submodule update --remote --merge

.PHONY: verify
verify:
	@git --version
	@cargo --version
	@rustc --version