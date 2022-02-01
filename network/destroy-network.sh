#!/bin/sh
echo "Destroying Basic DLT Network"

cd test-network

./network.sh down -verbose

echo "Network destroyed"