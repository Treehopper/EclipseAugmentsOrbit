# EclipseAugmentsOrbit
Eclipse Augs Dependencies missing in Eclipse Orbit
Downloads maven artifacts, converts them into OSGi bundles and aggregates them as a p2 updatesite.

## Build and Deploy
$ gradle

## Test
$ groovy serveUpdateSite.groovy
Find p2 repository under http://localhost:8080/

$ ls build/updatesite/