# Helidon + Fn 

Like lamb and tunafish.

This short demo uses Helidon as the receiver for a Google Home device, which in turn calls an Fn Flow function which in turn runs a workflow of Fn functions.

About as simple as a milkshake.

`fn.callFn("giphyfn/flow", input);`

Just make sure to import the caller.

`import io.helidon.examples.quickstart.fn.FnCaller;`

Oh and run `setenv.sh` to set the invoke endpoint.

Bonus: you can just `fn deploy` functions as opposed to redeploying the Helidon app.

Note: This doesn't use the Fn Java SDK which is not in a great state at the moment. Will use that next for a fresher cleaner feeling.

You'll also need the following code:

http://github.com/carimura/giphyfn

http://github.com/carimnura/tools/slack

Here's a short video of me talking to a robot:

[![IMAGE ALT TEXT HERE](https://img.youtube.com/vi/zy0NCNVcNhQ/0.jpg)](https://www.youtube.com/watch?v=zy0NCNVcNhQ)