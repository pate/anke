# Anke se Webtuiste

This is an example ClojureScript application that uses Reagent for rendering.

At build-time, ClojureScript files are transpiled to JavaScript, which can run in the browser.

# Requirements

- [Boot](http://boot-clj.com/) (a build tool for Clojure)
- [Clojure](http://clojure.org/downloads) - should be included with Boot
- [Divshot CLI](https://docs.divshot.com/guides/quick-start) (for deployment)

# How to Build

## Development

- Run `boot dev`
- Open a browser at `http://localhost:3003`.
- Open your favourite editor. Changing any files should trigger a rebuild and re-render your browser window.

## Production

`boot prod`

This will compile ClojureScript with optimizations and a lot smaller codebase for deplyoment.

# Deployment

`divshot push production`
