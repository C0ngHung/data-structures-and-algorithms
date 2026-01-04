package org.conghung.datastructuresandalgorithms.dsa.hashtable;

public class Definition {
    // hashtable luôn gặp 2 thứ đó là key và value
    // hashtable always involves 2 things: key and value
    // key là duy nhất, value có thể trùng lặp
    // key is unique, value can be duplicated
    // hashtable là một cấu trúc dữ liệu lưu trữ các cặp key-value
    // hashtable is a data structure storing key-value pairs
    // trong đó mỗi key được ánh xạ đến một value thông qua một hàm băm (hash function)
    // where each key is mapped to a value via a hash function
    // Ứng dụng của hashtable:
    // Applications of hashtable:
    // 1. Tìm số lần lặp lại của 1 thứ gì đấy trong (mảng, chuỗi, danh sách liên kết,...)
    // 1. Find the frequency of something in (array, string, linked list,...)
    // key, value không nhất thiết phải là số hoặc chữ cái, có thể là object
    // key, value do not have to be numbers or letters, can be objects
    // Điều đặc biệt là key phải là hashable (có thể chuyển đổi thành một giá trị băm)
    // The special thing is key must be hashable (convertible to a hash value)
    // hash function (hx) sẽ map cái key với 1 con số nào đấy nằm trong 1 khoảng
    // hash function (hx) will map the key to a number within a range
    // bản chất của hashtable là một mảng (array) được mở rộng với các hàm băm để ánh xạ key với index trong mảng
    // essentially hashtable is an array extended with hash functions to map key to index in array
    // thành ra khi người ta hash key thì người ta sẽ biết được key nằm ở vị trí nào trong cái range của mảng đó
    // so when hashing key, we know exactly its position in that array's range

    // Example: h (x) = ( x^2 + 2x + 1) mod 10
    // Example: h(x) = (x^2 + 2x + 1) mod 10
    // luôn trả về một giá trị trong khoảng từ 0 đến 9
    // always returns a value in range 0 to 9
    // h (2)  = ( 2^2 + 2*2 + 1) mod 10 = 9
    // h(2) = (2^2 + 2*2 + 1) mod 10 = 9
    // h(3) = ( 3^2 + 2*3 + 1) mod 10 = 6
    // h(3) = (3^2 + 2*3 + 1) mod 10 = 6
    // Khi mà chúng ta hash 1 cái key thì chúng ta sẽ nhận lại được 1 cái index nằm trong 1 range nhất định của chúng ta
    // When we hash a key, we receive an index within our specific range
    // hash function của những class trong IDE IntelliJ để nó sẽ bốc đống thông tin có trong class đấy và map đống thông
    // hash function of classes in IntelliJ IDE picks up info in that class and maps that info
    // tin đó về với 1 giá trị ở trong khoảng nào đó
    // to a value within some range

    // Khi h (x)  = h (y) thì x và y có thể bằng nhau
    // When h(x) = h(y) then x and y might be equal
    // Nhưng nếu h (x) khác h (y) thì x và y chắc chắn khác nhau
    // But if h(x) != h(y) then x and y are definitely different

    // Áp dụng vào thực tế khi tải những file rất lớn từ internet
    // Applied in reality when downloading very large files from internet
    // người ta sẽ chia nhỏ file đó thành nhiều phần khác nhau và hash từng phần một
    // people split the file into many parts and hash each part
    // để khi tải về người ta sẽ biết phần nào bị thiếu và chỉ cần tải lại phần bị thiếu đó thôi
    // so upon download they know which part is missing and only re-download that missing part

    // Ứng dụng trong software: Khi so sánh 2 object rất lớn thay vì so sánh thẳng 2 object đó
    // Application in software: When comparing 2 very large objects instead of direct comparison
    // người ta sẽ hash 2 object đó và so sánh giá trị băm của 2 object đó với nhau
    // people hash 2 objects and compare their hash values
    // nếu giá trị băm khác nhau thì chắc chắn 2 object đó khác nhau
    // if hash values differ then objects are definitely different
    // nếu giá trị băm giống nhau thì người ta sẽ so sánh trực tiếp 2 object đó với nhau
    // if hash values are same then they compare objects directly

    // hash function có thể gọi là cố định có nghĩa là khi hash 1 key nào đấy thì nó luôn trả về 1 giá trị băm giống nhau
    // hash function can be called deterministic meaning hashing a key always returns same hash value
    // ví dụ: hash("conghung") luôn trả về 123456789 hash 100 lần thì luôn trả về 123456789
    // example: hash("conghung") always returns 123456789, hashing 100 times returns 123456789
    // Đừng bao giờ để hash function chịu ảnh hưởng bởi các yếu tố bên ngoài như thời gian hiện tại, ngẫu nhiên,...
    // Never let hash function be affected by external factors like current time, random,...

    // Collisions (xung đột): xảy ra khi 2 key khác nhau được hash về cùng 1 giá trị băm
    // Collisions: occur when 2 different keys are hashed to the same hash value
    // Ví dụ: h("conghung") = 123456789 và h("conghung1") = 123456789
    // Example: h("conghung") = 123456789 and h("conghung1") = 123456789
    // Cách giải quyết collisions:
    // How to resolve collisions:
    // 1. Separate Chaining: sử dụng một cấu trúc dữ liệu phụ (như linked list hoặc tree) để lưu trữ các cặp key-value có cùng giá trị băm tại cùng một vị trí trong mảng chính của hashtable.
    // 1. Separate Chaining: use auxiliary data structure (like linked list or tree) to store key-value pairs with same hash value at same position in main hashtable array.
    // 2. Open Addressing: tìm kiếm vị trí trống tiếp theo trong mảng chính của hashtable để lưu trữ cặp key-value khi xảy ra collisions.
    // 2. Open Addressing: search for next empty slot in main hashtable array to store key-value pair when collisions occur.
    // Vídụ: h(x) = h (y)
    // Example: h(x) = h(y)
    // h (a) = (a + 1)^2 mod 10
    // h (a) = (a + 1)^2 mod 10
    // h (3) = (3 + 1)^2 mod 10 = 6, h (5) = (5 + 1)^2 mod 10 = 6
    // h (3) = (3 + 1)^2 mod 10 = 6, h (5) = (5 + 1)^2 mod 10 = 6
    // Cách giải quyết:
    // Solution:
    // Chúng ta sẽ phải có 1 hashtable đủ lớn để khi chúng ta mod size của nó sẽ không bị collisions
    // We must have a hashtable large enough so when modding its size collisions are minimized

    // hash function uniform là một hash function tốt chống collisions
    // uniform hash function is a good hash function against collisions
    // Complexity phụ thuộc vào cách giải quyết collisions có thể là O(1) hoặc O(n)
    // Complexity depends on collision resolution, can be O(1) or O(n)
}

