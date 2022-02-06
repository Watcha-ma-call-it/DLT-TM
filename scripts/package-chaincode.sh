#!/bin/sh
REPO_ROOT="${HOME}/DLT-TM"

export FABRIC_CFG_PATH=${REPO_ROOT}/network/config/

echo "Packaging Translation Memory Chaincode"

echo "Building Chaincode"
cd ${REPO_ROOT}/chaincode/

if  ./gradlew installDist ;
then
  echo "Built Chaincode"
else
  echo "Unable to build chaincode, exiting"
  exit 1
fi


PEER="${REPO_ROOT}/network/binaries/peer"
PACKAGE_NAME="translation-memory-chaincode.tar.gz"

echo "Packaging Chaincode to ${PACKAGE_NAME}"

if $PEER version ;
then
  echo "Peer CLI Installed"
else
  echo "Peer CLI not installed, exiting"
  exit 1
fi

PACKAGE_COMMAND="${PEER} lifecycle chaincode package ${PACKAGE_NAME} --path ${REPO_ROOT}/chaincode/build/install/translation-memory --lang java --label translation-memory_1"

if $PACKAGE_COMMAND ;
then
  echo "Packaged Chaincode to ${PACKAGE_NAME}"
else
  echo "Unable to package chaincode"
  exit 1
fi