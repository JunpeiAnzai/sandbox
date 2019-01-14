#[cfg(test)]

struct Circle {
    x: f64,
    y: f64,
    radius: f64
}
trait HasArea {
    fn area(&self) -> f64;
}

impl HasArea for Circle{
    fn area(&self) -> f64 {
        std::f64::consts::PI * (self.radius * self.radius)
    }
}
impl Circle {
    fn area(&self) -> f64 {
        std::f64::consts::PI * (self.radius * self.radius)
    }
}


mod tests {
    #[test]
    fn it_works() {
        assert_eq!(2 + 2, 4);
    }
}
