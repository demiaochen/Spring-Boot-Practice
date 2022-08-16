#!/bin/dash

# brew install maven
if ! command -v mvn &> /dev/null; then
  # opkg install mvn
  brew install mvn
fi

mvn spring-boot:run
