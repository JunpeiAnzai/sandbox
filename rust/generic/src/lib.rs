#[cfg(test)]

enum Option<T> {
    Some(T),
    None,
}

enum Result<A, Z> {
    Ok(A),
    Err(Z),
}

struct point<T> {
    x: T,
    y: T
}

mod tests {
    #[test]
    fn it_works() {
        assert_eq!(2 + 2, 4);
        let x: Option<i32> = Some(5);
        let y: Option<f64> = Some(5.0f64);
    }
    fn takes_anything<T>(x: T) {
        // something
    }

    fn takes_two_things<T, U>(x: T, y: U) {
        //
    }
}
