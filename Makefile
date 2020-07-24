SUBMODULES = gateway member-service product-service trade-service

.PHONY: all $(SUBMODULES)

all: $(SUBMODULES)

$(SUBMODULES):
	$(MAKE) -C $@ docker tag push
