# AI Usage Reflection

## 1. Which AI tools did you use?

I used **Claude Code**.

## 2. An interaction that helped me

I asked the AI whether I could simplify my `combine` method.

**Prompt:**

> "I have a method `combine` in Java which concatenates a String from rule
> labels. If no rule matches the number, the method returns the number itself.
> I use a `StringBuilder` and at the end I check if it is empty. Can I simplify
> it? Give me some suggestions."

(I also pasted the method code.)

**Summary of the response:**

The AI suggested replacing the final `if/else` block with a ternary operator,
so the method ends with a single return:

    return result.isEmpty() ? String.valueOf(number) : result.toString();

It explained that this keeps the logic identical but makes the method shorter
and easier to read.

**What I took from it and why it was useful:**

I adopted the ternary version because it removed the extra `if/else` without
changing the behaviour and made the method easier to read at a glance.

## 3. An AI suggestion I modified or rejected

In the same conversation, the AI suggested rewriting the method using the
Stream API instead of a `StringBuilder`:

    rules.stream()
         .filter(rule -> rule.matches(number))
         .map(AlertRule::label)
         .collect(Collectors.joining());

**Why I didn't use it as-is:**

The stream version handles only the concatenation of matching labels. It does
not naturally cover the case where no rule matches and the method has to return
the number itself. Adding that fallback to the stream made it less readable
than the original.

**What I did instead:**

I kept the `StringBuilder` with a ternary that returns the number when the
result is empty. It expresses the "no match" case explicitly and stays easier
to follow.
