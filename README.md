# My Markdown

This is an extensible Markdown to HTML converter written in Java. The main 
feature of the converter is the extensibility of the Markdown syntax.

Currently there is one extension implemented as a Java class in the converter
which I use to render question-answer exercises to memorize technologies.

Example syntax:
```markdown
exercise
    Print "Hello World!" in Bash.

    ```sh
    echo "Hello, World!"
    ```
```

The `exercise` keyword must not be intented. Then follows a block of text 
indented by exactly four spaces. The lines until the first empty 
line will form the question part of the exercise, then the rest will form the
answer.

## Installation 

```shell
curl -fsSL https://raw.githubusercontent.com/sandor-juhasz/mymarkdown/main/install.sh | bash -s
./install
```

The JAR file is coped to `/.local/share/mymarkdown` and the wrapper script to 
`/.local/bin`.

## Usage

To invoke the converter, use the following command:
```shell
mymarkdown input.md output.html
```

Once the converter completes, the exercise is rendered as the following:

```html
<div class="exercise">
<div class="question">
Print &ldquo;Hello World!&rdquo; in Bash.</div>
<div class="answer">
<pre class="prettyprint"><code class="sh">echo "Hello, World!"
</code></pre>
</div>
</div>
```

The converter currently contains a built in template and css which is used 
to generate the html file. The style.css file is also generated in the same
directory.

## Usage of the container

To build the mymarkdown container, execute

```shell
docker build . -t sjuhasz/mymarkdown
```

To execute the container, mount the directory to be processed under /mnt. The
HTML files will be generated under `/mnt/target`.

```shell
dir_to_process=/mnt/c/Dev/Projects/t
docker run --rm \
    --mount "type=bind,source=$dir_to_process,target=/mnt" \
    sjuhasz/mymarkdown
```
