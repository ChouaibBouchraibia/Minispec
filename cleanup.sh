#!/bin/bash

# Remove all files ending with -out.xml in current directory
rm -f *-out.xml

# Remove output directory if it exists
rm -rf output

echo "Cleanup completed: Removed all *-out.xml files and output directory"