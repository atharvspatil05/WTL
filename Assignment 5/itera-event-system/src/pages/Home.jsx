function Home() {
  return (
    <div className="bg-gray-100 min-h-screen flex flex-col justify-center items-center text-center p-10">
      <h1 className="text-5xl font-extrabold mb-4 text-blue-700">Welcome to ITERA Event Management</h1>
      <p className="text-lg text-gray-700 mb-6 max-w-xl">
        Discover upcoming events, join clubs, and register for activities.  
        Stay connected with the vibrant community at ITERA.
      </p>
      <a href="/events" className="bg-blue-600 text-white px-6 py-3 rounded-full shadow hover:bg-blue-700 transition">
        View Events
      </a>
    </div>
  );
}

export default Home;