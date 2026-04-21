function Clubs() {
  const clubs = [
    "Coding Club",
    "Robotics Club",
    "Cultural Club",
    "Photography Club",
    "Entrepreneurship Club"
  ];

  return (
    <div className="p-8 bg-gray-100 min-h-screen">
      <h2 className="text-3xl font-bold mb-8 text-gray-800">Explore Clubs</h2>
      <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 gap-6">
        {clubs.map((club, index) => (
          <div
            key={index}
            className="bg-white p-6 shadow-lg rounded-xl text-center hover:shadow-2xl transition"
          >
            <h3 className="text-xl font-semibold">{club}</h3>
          </div>
        ))}
      </div>
    </div>
  );
}

export default Clubs;