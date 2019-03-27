# Helidon + Fn 

Like lamb and tunafish.

This is just 23 lines of code to trigger an Fn function from a Helidon microservice using the format:

`fn.callFn("hello-trigger");`

Just make sure to import the caller.

`import io.helidon.examples.quickstart.fn.FnCaller;`

Then you can just `fn deploy` the function as opposed to redeploying the Helidon app.

Oh and run `setenv.sh` to set the invoke endpoint.

Note: This doesn't use the Fn Java SDK which is not in a great state at the moment. Will use that next for a fresher clean feeling.

