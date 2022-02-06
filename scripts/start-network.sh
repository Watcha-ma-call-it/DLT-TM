#!/bin/sh
echo "Starting a basic DLT Network"

cd ../network/test-network

./network.sh up createChannel -verbose

echo "Network created"