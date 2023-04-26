**Introduction**

This program includes a high level blueprint/abstraction of a mass-mailing application with the aim of sending an arbitrary message to a list of users that need to be contacted from an input file (example file: test_user_data.txt).
Some of the users might be inactive, which means they shouldn't receive any message.

**What would've been improved if I had got more time ?**

I'd have implemented inversion of control better. Instead of just broadly instantiating the project's objects via constructors, I could've used more sophisticated approaches. For example, making use of annotations, more automated ways to detect objects and their dependencies (similar to what the spring framework does), maybe even implementing some JSRs to make the app more portable and easy to migrate lately.
One of the requirements is performance, the app is meant to handle a billions worth users as an input, so the usage of compression and batching is highly recommended in this case.
A retry mechanism is also welcome. Combined with a messaging asset to record events, It'd be possible to re-process from the point of failure instead of starting the whole treatment from the first line of the input file.
Data integrity is a huge subject as well, what would happen if two files containing several batches of the same users were to be processed one after another ? How should we handle unicity ?
What about the usage of multiple threads instead of a single one ? Multithreading is a huge subject by itself with a whole lot of issues regarding it.
Ultimately, using performance tools is a must in this kind of HPC projects.
