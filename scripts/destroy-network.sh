#!/bin/sh
echo "Destroying Basic DLT Network"

cd ../network/test-network

./network.sh down -verbose

echo "Network destroyed"